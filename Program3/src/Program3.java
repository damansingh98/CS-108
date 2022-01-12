// author: Damandeep Singh

import java.io.*;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.InputMismatchException;

public class Program3 {
    public static void main(String[] args) throws IOException {
        Program3.DNA2RNA("1.txt", "100.txt");
    }

    public static void DNA2RNA(String DNAFile, String RNAFile) throws IOException{
        //Create buffer reader and write to read and write data
        FileReader fileReader = new FileReader(DNAFile);
        BufferedReader br = new BufferedReader(fileReader);
        FileWriter fileWriter  = new FileWriter(RNAFile);
        BufferedWriter bw = new BufferedWriter(fileWriter);

        //read the data in DNA file and store it to a single string
        String dnaSequence = br.readLine();
        // As long as DNA file is not empty
        while (dnaSequence != null){
            // capitalize all letters of the String in case there are non capitalized characters
            dnaSequence = dnaSequence.toUpperCase();

            // try and catch to handle the IOException
            try {
                // Create a string that is mutable
                StringBuilder RnaSequence = new StringBuilder();
                //convert the string to char array
                char[] sequence = dnaSequence.toCharArray();
                //iterate forward through each character
                for (char nucleotide: sequence){
                    if(nucleotide == 'C'){ //replace C with G

                        RnaSequence.append("G");

                    } else if(nucleotide == 'G'){ //replace G with C

                        RnaSequence.append("C");
                    }
                    else if(nucleotide == 'A'){ //replace A with U

                        RnaSequence.append("U");
                    }
                    else if(nucleotide == 'T'){ //replace T with A

                        RnaSequence.append("A");

                    }else {
                        // throw exception if a character is not a part of DNA
                        throw new NoSuchElementException("Not a DNA character");
                    }
                }

                // write the modified String to the RNA file
                bw.write(RnaSequence +"\n");
                // read the next line in the DNA file
               dnaSequence=  br.readLine();

               //handle the exception
            }catch (IOException e){
                // prints description and message of exception
                e.printStackTrace();
            }
        }
        // close the reader and writer, the file RNA.txt is generated.
        br.close();
        bw.close();
        fileReader.close();
        fileWriter.close();

    }
    public static void RNA2Protein(String RNAFile, String ProteinFile, String RNA2ProteinTable) throws IOException{
        //Create buffer reader and write to read and write data
         FileReader file = new FileReader(RNA2ProteinTable);
         BufferedReader readSeq = new BufferedReader(file);
         FileWriter writ = new FileWriter(ProteinFile);
         BufferedWriter writeSeq = new BufferedWriter(writ);

        //create a hashmap to store the Rna triplet as key and protein character as value
        HashMap<String, String> hashMap = new HashMap<>();

        try {
            // Read the sequence and store it to a single string
            String triple = readSeq.readLine();

            // As long as string is not empty
            while (triple != null){
                //create an array of string and store the words and wherever there is spacing
                String[] store = triple.split(" ");

                // put the triplet sequence as key and protein character as value
                hashMap.put(store[0],store[1]); // (key, value)

                // keep reading all the lines in the file
                triple = readSeq.readLine();

            }
            // close the buffer reader for RNA2Protein table file
            readSeq.close();

            // open the buffer reader again with RNA file
            readSeq = new BufferedReader(new FileReader(RNAFile));

            // Store the rna sequence as a string and read file
            String rnaSeq = readSeq.readLine();

            //As long as rna string is not empty
            while (rnaSeq != null){
                // to make sure the rna sequence is divisible by 3 for length
                if(rnaSeq.length() %3 == 0){
                    // create a mutable string for protein
                    StringBuilder protein = new StringBuilder();

                    //Iterate through the rna sequence with every three step
                    for (int i = 0; i < rnaSeq.length(); i +=3){

                        // store the triplet using the substring method
                        String triplet = rnaSeq.substring(i, i+3);

                        // extract the value of the protein character and append
                        protein.append(hashMap.get(triplet));

                    }
                    //write the sequence into the file Protein.txt
                    writeSeq.write(protein+"\n");
                }else {
                    // throw exception if RNA sequence length is not 3
                    throw new InputMismatchException("Invalid RNA length");
                }
                // move to next line in the file and read
                rnaSeq = readSeq.readLine();
            }
            // catch exception
        }catch (IOException e){
            e.printStackTrace();
        }
        // close buffer/file reader and buffer/file writer
        readSeq.close();
        writeSeq.close();
        file.close();
        writ.close();

    }

}
