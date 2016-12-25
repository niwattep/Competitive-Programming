import java.util.*;

import java.io.*;
class Main {
	public static void main(String[] args) throws IOException {
		FastReader in = new FastReader();
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder(25000);
		
		int[] lB = new int[1000010];
		int[] rB = new int[1000010];
		
		while (in.hasNext()) {
			int s = in.nextInt();
			int b = in.nextInt();
			if (s != 0 && b != 0) {
				lB[0] = rB[0] = 0;
				for (int i = 1; i <= s; i++) {
					lB[i] = i - 1;
					rB[i] = i + 1;
				}
				rB[s] = 0;
				int l, r, sL, sR;
				for (int i = 0; i < b; i++) {
					l = in.nextInt();
					r = in.nextInt();
					sL = lB[l];
					sR = rB[r];
					String x = (sL == 0) ? "*" : String.valueOf(sL);
					String y = (sR == 0) ? "*" : String.valueOf(sR);
					sb.append(x + " " + y + "\n");
					lB[sR] = sL;
					rB[sL] = sR;
				}
				sb.append("-\n");
			}
			if (sb.length() >= 10000) {
				out.write(sb.toString());
				sb = new StringBuilder(25000);
			}
		}
		out.write(sb.toString());
		out.flush();
		out.close();
	}
	
	static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;
 
        public FastReader()
        {
            br = new BufferedReader(new
                     InputStreamReader(System.in));
        }
        
        boolean hasNext() {
        	try {
				//if (st == null || !st.hasMoreElements()) return true;
        		return br.ready() || st == null;
			} catch (Exception e) {
				e.printStackTrace();
			}
        	return false;
        }
 
        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException  e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
 
        int nextInt()
        {
            return Integer.parseInt(next());
        }
 
        long nextLong()
        {
            return Long.parseLong(next());
        }
 
        double nextDouble()
        {
            return Double.parseDouble(next());
        }
 
        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }
}

