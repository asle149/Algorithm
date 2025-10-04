import java.io.*;

public class Main {
    static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;
        FastScanner(InputStream is) { in = is; }
        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }
        int nextInt() throws IOException {
            int c, sign = 1, val = 0;
            do { c = read(); } while (c <= ' ');      
            if (c == '-') { sign = -1; c = read(); }
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }
            return val * sign;
        }
    }

    static void heapify(int[] a, int n) {         
        for (int i = (n >>> 1) - 1; i >= 0; i--) down(a, i, n);
    }
    static void down(int[] a, int i, int n) {     
        while (true) {
            int l = (i << 1) + 1;
            if (l >= n) break;
            int r = l + 1;
            int m = (r < n && a[r] < a[l]) ? r : l; 
            if (a[i] <= a[m]) break;
            int t = a[i]; a[i] = a[m]; a[m] = t;
            i = m;
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        int n = fs.nextInt();

        int[] heap = new int[n];
        int filled = 0;

        for (int i = 0; i < n; i++) {
            heap[filled++] = fs.nextInt();
        }
        heapify(heap, n);

        int total = n * n - n;
        for (int k = 0; k < total; k++) {
            int x = fs.nextInt();
            if (x > heap[0]) {         
                heap[0] = x;
                down(heap, 0, n);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(heap[0]).append('\n');
        System.out.print(sb);
    }
}
