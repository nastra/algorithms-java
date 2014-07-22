package com.nastra.algorithms.search;

public class SuffixAutomata {
    private Vertex root;
    private Vertex last;

    private class Vertex {
        Vertex suffixLink = null;
        Vertex[] edges;
        int log = 0;
        boolean visited = false;
        int terminals = 0;

        public Vertex(Vertex o, int log) {
            edges = o.edges.clone();
            this.log = log;
        }

        public Vertex(int log) {
            edges = new Vertex[26];
            this.log = log;
        }
    }

    public SuffixAutomata(String str) {
        last = root = new Vertex(0);
        for (int i = 0; i < str.length(); i++) {
            addChar(str.charAt(i));
        }
        addTerminal();
    }

    private void addChar(char c) {
        Vertex cur = last;
        last = new Vertex(cur.log + 1);
        while (cur != null && cur.edges[c - 'a'] == null) {
            cur.edges[c - 'a'] = last;
            cur = cur.suffixLink;
        }
        if (cur != null) {
            Vertex q = cur.edges[c - 'a'];
            if (q.log == cur.log + 1) {
                last.suffixLink = q;
            } else {
                Vertex r = new Vertex(q, cur.log + 1);
                r.suffixLink = q.suffixLink;
                q.suffixLink = r;
                last.suffixLink = r;
                while (cur != null) {
                    if (cur.edges[c - 'a'] == q) {
                        cur.edges[c - 'a'] = r;
                    } else {
                        break;
                    }
                    cur = cur.suffixLink;
                }
            }
        } else {
            last.suffixLink = root;
        }
    }

    private void addTerminal() {
        Vertex cur = last;
        while (cur != null) {
            cur.terminals++;
            cur = cur.suffixLink;
        }
    }
}
