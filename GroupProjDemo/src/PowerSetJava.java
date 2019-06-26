// PowerSet.java
import java.util.*;


final class PowerSetJava {
    private int[] set;
    private List items = Collections.emptyList();

    private final void getPowerSet(int k, int x) {
        if (k >= x) {
            int[] set = this.set;
            Collection destination$iv$iv = (Collection)(new ArrayList(set.length));

            for(int i = 0; i < set.length; ++i) {
                int item$iv$iv = set[i];
                destination$iv$iv.add(this.items.get(item$iv$iv));
            }

            System.out.println((List)destination$iv$iv);
        } else {
            int j = 0;

            for(int var4 = this.items.size(); j < var4; ++j) {
                if (k == 0 || j > this.set[k - 1]) {
                    this.set[k] = j;
                    this.getPowerSet(k + 1, x);
                }
            }
        }

    }

    public final List getItems() {
        return this.items;
    }

    public PowerSetJava( List items) {
        this.items = items;
        this.set = new int[0];
        String var2 = "Power set of " + this.items + " is:";
        System.out.println(var2);
        int x = 0;
        int var3 = this.items.size();
        if (x <= var3) {
            while(true) {
                this.set = new int[x];
                this.getPowerSet(0, x);
                if (x == var3) {
                    break;
                }

                ++x;
            }
        }

    }
    // PowerSetMain.java
    public class PowerSetMainJava {
        public final void main() {
            Scanner scanner = new Scanner(System.in);
            String stringInput = "Enter csv of integers: ";
            System.out.print(stringInput);
            try {
                stringInput = scanner.nextLine();
            }
            catch (Exception e){
                System.out.println(e);
            }
            Collection destination$iv$iv = (Collection)(new ArrayList());
            List csv = (List)(new ArrayList());

            for(int i = 0; i < stringInput.split(",").length; i++){
                destination$iv$iv.add(stringInput.split(",")[i]);
                csv.add(stringInput.split(",")[i]);

            }
            new PowerSet(csv);
            System.out.println();
        }
    }
}