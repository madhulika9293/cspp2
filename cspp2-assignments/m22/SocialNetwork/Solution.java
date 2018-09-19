import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;

public final class Solution {

  private Solution() {
    //unused
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    SocialNetwork myNet = new SocialNetwork();

    Integer numLines = Integer.parseInt(scan.nextLine().split(" ")[1]);

    for (int i = 0; i < numLines; i++) {
      String line = scan.nextLine();
      String[] inputs = line.replace(".", "").split(" is connected to ");
      myNet.addToNetwork(inputs[0], inputs[1].split(", "));
    }

    while (scan.hasNext()) {
      String[] inputs = scan.nextLine().split(" ");
      switch (inputs[0]) {
      case "Network":
        ArrayList<String> keysSort = new ArrayList<>(myNet.getNetwork().keySet());
        Collections.sort(keysSort);
        String s = "";
        for (String item : keysSort) {
          s = s + item + ":" + myNet.getNetwork().get(item).toString() + ", ";
        }
        System.out.println(s.substring(0, s.length() - 2));
        break;
      case "addConnections":
        myNet.addConnections(inputs[1], inputs[2]);
        break;
      case "getConnections":
        if (myNet.getNetwork().containsKey(inputs[1])) {
          System.out.println(myNet.getConnections(inputs[1]));
        } else {
          System.out.println("Not a user in Network");
        }
        break;
      case "CommonConnections":
        System.out.println(myNet.getCommonConnections(inputs[1], inputs[2]));
      default:
        break;
      }
    }
  }
}

