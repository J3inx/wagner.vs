package oregonTrail;

import java.util.ArrayList;
import java.util.Scanner;

public class FakeOregonTrail {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int progress = 1;
        boolean alive = true;
        boolean win = false;
        ArrayList<String> inventory = new ArrayList<>();
        double deathRisk = 0.5;
        int lowerDeathRiskCost = 1;

        System.out.println("You just got off the highway and arrive in Falls Church.\nYou are trying to drive down Broad Street. What do you do?\n");

        while (alive && !win) {
            if (progress == 6) {
                System.out.println("Congratulations! You successfully drove through Falls Church to avoid 66 traffic!");
               
                win = true;
                break;
            }

            System.out.println("Current stage: " + progress);
            System.out.println("1. Go straight\n2. Look around\n3. Talk to locals\n4. Visit the shop\n5. Look at inventory");
            int choice = kb.nextInt();

            if (choice == 1) { // Go straight
                if (Math.random() <= deathRisk) {
                    System.out.println("You drive forward successfully.");
                    progress++;
                } else {
                    if (Math.random() <= 0.5) {
                        System.out.println("You werent paying attention and ran a red light, getting hit by one of the\ndump trucks coming from the meridian construction site. you die since the \nbroad street congestion stops the ambulance from getting to you ");
                        
                        alive = false;
                    } else {
                        System.out.println("You hit a pothole, breaking your tire rod, causing you to steer hard right \nflipping your car and rolling you. you die since the\nbroad street congestion stops the ambulance from getting to you");
                        alive = false;
                    }
                }
            } else if (choice == 2) { // Look around
                describeLocation(progress);
            } else if (choice == 3) { // Talk to locals
                System.out.println("The locals give you vague and unhelpful advice.");
            } else if (choice == 4) { // Visit the shop
                progress = shop(kb, progress, inventory, deathRisk, lowerDeathRiskCost);
            } else if (choice == 5) { // Look at inventory
                if (inventory.isEmpty()) {
                    System.out.println("Your inventory is empty.");
                } else {
                    System.out.println("Inventory: " + inventory);
                    System.out.println("Would you like to use an item? (1 for Yes, 2 for No)");
                    int useChoice = kb.nextInt();
                    if (useChoice == 1) {
                        System.out.println("Select an item to use: " + inventory);
                        for (int i = 0; i < inventory.size(); i++) {
                            System.out.println((i + 1) + ". " + inventory.get(i));
                        }
                        int itemChoice = kb.nextInt();
                        if (itemChoice > 0 && itemChoice <= inventory.size()) {
                            String item = inventory.remove(itemChoice - 1);
                            if (item.equals("Skip Ahead")) {
                                System.out.println("You used Skip Ahead and moved forward one stage.");
                                progress++;
                            } else if (item.equals("Revive")) {
                                System.out.println("You used Revive. This item can only be used after death.");
                                inventory.add("Revive"); // Add back if used improperly
                            } else {
                                System.out.println("Invalid item.");
                            }
                        } else {
                            System.out.println("Invalid choice.");
                        }
                    }
                }
            } else {
                System.out.println("Invalid choice. Try again.");
            }

            if (!alive && inventory.contains("Revive")) {
                System.out.println("You have died. Would you like to use a Revive? (1 for Yes, 2 for No)");
                int reviveChoice = kb.nextInt();
                if (reviveChoice == 1) {
                    System.out.println("You used a Revive and return to the previous stage.");
                    alive = true;
                    progress = Math.max(1, progress - 1);
                    inventory.remove("Revive");
                }
            }
        }

        if (!alive && !win) {
            System.out.println("You have died. Better luck next time.");
            System.out.println("                      :::!~!!!!!:.\n"
        			+ "                  .xUHWH!! !!?M88WHX:.\n"
        			+ "                .X*#M@$!!  !X!M$$$$$$WWx:.\n"
        			+ "               :!!!!!!?H! :!$!$$$$$$$$$$8X:\n"
        			+ "              !!~  ~:~!! :~!$!#$$$$$$$$$$8X:\n"
        			+ "             :!~::!H!&lt;   ~.U$X!?R$$$$$$$$\n"
        			+ "             ~!~!!!!~~ .:XW$$$U!!?$$$$$$RMM!\n"
        			+ "               !:~~~ .:!M\"T#$$$$WX??#MRRMMM!\n"
        			+ "               ~?WuxiW*`   `\"#$$$$8!!!!??!!!\n"
        			+ "             :X- M$$$$       `\"T#$T~!8$WUXU~\n"
        			+ "            :%`  ~#$$$m:        ~!~ ?$$$$$$\n"
        			+ "          :!`.-   ~T$$$$8xx.  .xWW- ~\"\"##*\"\n"
        			+ ".....   -~~:&lt;` !    ~?T#$$@@W@*?$$      \n"
        			+ "W$@@M!!! .!~~ !!     .:XUW$W!~ `\"~:    :\n"
        			+ "#\"~~`.:x%`!!  !H:   !WM$$$$Ti.: .!WUn+!`\n"
        			+ ":::~:!!`:X~ .: ?H.!u \"$$$B$$$!W:U!T$$M~\n"
        			+ ".~~   :X@!.-~   ?@WTWo(\"*$$$W$TH$! `\n"
        			+ "Wi.~!X$?!-~    : ?$$$B$Wu(\"**$RM!\n"
        			+ "$R@i.~~ !     :   ~$$$$$B$$en:``\n"
        			+ "?MXT@Wx.~    :     ~\"##*$$$$M~");
            
            
        } else if (win) {
        	 System.out.println("  _______________\n"
         			+ "    |@@@@|     |####|\n"
         			+ "    |@@@@|     |####|\n"
         			+ "    |@@@@|     |####|\n"
         			+ "    \\@@@@|     |####/\n"
         			+ "     \\@@@|     |###/\n"
         			+ "      `@@|_____|##'\n"
         			+ "           (O)\n"
         			+ "        .-'''''-.\n"
         			+ "      .'  * * *  `.\n"
         			+ "     :  *       *  :\n"
         			+ "    : ~     U     ~ :\n"
         			+ "    : ~   W I N!  ~ :\n"
         			+ "     :  *       *  :\n"
         			+ "      `.  * * *  .'\n"
         			+ "        `-.....-'");
        }
    }

    private static void describeLocation(int progress) {
        switch (progress) {
            case 1:
                System.out.println("You are by the school. Across the street is a McDonald's and a local vet.");
                break;
            case 2:
                System.out.println("You are at the corner of Founders Row. There's a Taco Bell nearby.");
                break;
            case 3:
                System.out.println("You are near a Harris Teeter under an apartment complex.");
                break;
            case 4:
                System.out.println("You are by Brown's Hardware and a random brick office building.");
                break;
            case 5:
                System.out.println("You're on the home stretch. There's a church where cops monitor speeding.");
                break;
        }
    }

    private static int shop(Scanner kb, int progress, ArrayList<String> inventory, double deathRisk, int lowerDeathRiskCost) {
        System.out.println("  +----------------------+\n" +
                           "  |         SHOP         |\n" +
                           "  +----------------------+\n" +
                           "  | 1. Skip Ahead (1$)   |\n" +
                           "  | 2. Revive (3$)       |\n" +
                           "  | 3. Lower Death Risk  (" + lowerDeathRiskCost + "$)|\n" +
                           "  +----------------------+");
        System.out.println("Your currency: " + progress + "$ (current stage).\nChoose an option:");
        int shopChoice = kb.nextInt();
        switch (shopChoice) {
            case 1: // Skip ahead
                if (progress >= 1) {
                    System.out.println("You purchased Skip Ahead.");
                    inventory.add("Skip Ahead");
                    progress -= 1;
                } else {
                    System.out.println("Not enough currency.");
                }
                break;
            case 2: // Revive
                if (progress >= 3) {
                    System.out.println("You purchased a Revive.");
                    inventory.add("Revive");
                    progress -= 3;
                } else {
                    System.out.println("Not enough currency.");
                }
                break;
            case 3: // Lower death risk
                if (progress >= lowerDeathRiskCost) {
                    System.out.println("You purchased Lower Death Risk. Your chance of dying has decreased.");
                    deathRisk /= 2;
                    progress -= lowerDeathRiskCost;
                    lowerDeathRiskCost = Math.min(3, lowerDeathRiskCost + 1);
                } else {
                    System.out.println("Not enough currency.");
                }
                if (lowerDeathRiskCost > 3) {
                    System.out.println("Lower Death Risk is now sold out.");
                }
                break;
            default:
                System.out.println("Invalid shop choice.");
        }
        return progress;
    }
}
