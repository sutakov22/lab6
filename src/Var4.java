import java.io.*;

public class Var4 {
    public static void main(String[] args) throws IOException {
        BufferedReader inFile = null;
        BufferedWriter outFile = null;
        try {
            inFile = new BufferedReader(new FileReader("E:\\lab6_in.txt"),1024);
            outFile = new BufferedWriter(new FileWriter("E:\\lab6_out.txt"));
            int lineNum = 1;
            String line;
            while ((line = inFile.readLine()) != null) { // Читаем до конца файла
                String[] words = line.split(" "); // делим строку
                outFile.write("" + lineNum); // вывод номера строки

                int wordsCount = 0;
                if (words.length != 0) { // если строка пустая - пропускаем
                    int firstWordLength = words[0].length(); // длина первого слова
                    for (String word : words) {
                        if (word.length() < firstWordLength) { // если это слово короче первого
                            outFile.write(" " + word);
                            wordsCount++; // количество слов
                        }
                    }
                }

                outFile.write(" " + wordsCount + "\n");
                lineNum++; // номер строки
            }
        } catch (IOException e) {
            System.out.println("Ошибка!!!");
        }
        finally {
            inFile.close();
            outFile.flush();
            outFile.close();
        }
    }
}
