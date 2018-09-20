import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Set;
import java.io.*;

class Document {

  /**
   * given input document.
   */
  private String[] doc;

  /**
   * frequency of words in the given document.
   */
  private HashMap <String, Integer> docFreq;

  /**
   * Constructs the object.
   *
   * @param      docx  The docx
   */
  Document(final String[] docx) {
    doc = docx;
    docFreq = new HashMap<>();
  }

  public String[] getDoc() {
    return doc;
  }

  /**
   * Gets the frequency.
   *
   * @return     The frequency.
   */
  public HashMap getFreq() {
    for (String word : doc) {
      if (!docFreq.containsKey(word)) {
        docFreq.put(word, 1);
      } else {
        docFreq.put(word, docFreq.get(word) + 1);
      }
    }
    return docFreq;
  }

  public Integer getWordFreq(final String word) {
    return docFreq.get(word);
  }

  /**
   * Gets the modulus.
   *
   * @return     The modulus.
   */
  public double getMod() {
    double mod = 0.0;
    for (String word : docFreq.keySet()) {
      mod = mod + Math.pow(docFreq.get(word), 2);
    }
    return Math.sqrt(mod);
  }

  public double getDist(final Document doc2) {

    double dotProd = 0.0;
    double docDist = 0.0;

    Set<String> w1 = docFreq.keySet();
    Set<String> w2 = doc2.getFreq().keySet();
    w1.retainAll(w2);

    for (String word : w1) {
      dotProd += docFreq.get(word) * doc2.getWordFreq(word);
    }

    docDist = dotProd / (this.getMod() * doc2.getMod());

    return (int) docDist;
  }
}

public class Solution {
  public static void main(String[] args) {

    ArrayList<String> input = new ArrayList<String>();
    ArrayList<String> inputnames = new ArrayList<String>();

    Scanner sc = new Scanner(System.in);
    String string = sc.next();

    File file = new File(string);
    File[] listOfFiles = file.listFiles();

    for (File file1 : listOfFiles) {
      try {
        inputnames.add(file1.getName());
        Scanner sc1 = new Scanner(file1);
        String s = "";
        while (sc1.hasNext()) {
          s += sc1.nextLine() + " ";
        }
        // System.out.println(s);
        input.add(s.replaceAll("[^a-zA-Z0-9 ]", "").toLowerCase());
      } catch (Exception e) {
        System.out.println(e.getMessage());
      }
    }

    for (int i = 0; i < input.size(); i++) {
      String sOut = inputnames.get(i) + "\t";
      Document docCheck = new Document(input.get(i).split(" "));
      for (int j = 0; j < input.size(); j++) {
        Document docCheckWith = new Document(input.get(j).split(" "));
        sOut += docCheck.getDist(docCheckWith);
        sOut += "\t";
      }
    }
  }
}

