/*
SkiplistSSet
Version 1
14/enero/2017
Skiplist que implementa la interfaz de un SSet
*/

public class SkiplistSSet{
        private Node findPredNode(int i){
            Node u = sentinel;
            int r =h;
            while(r >= 0){
                while(u.next[r] != null && compare(u.next[r].x, x) < 0){
                    u = u.next[r];
                }
                r--;
            }
            return u;
        }

        public int find(int val){
            Node u = findPredNode(val);
            return u.next[0] == null ? null : u.next[0].x;
        }


}
