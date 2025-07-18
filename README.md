# Huffman_Coding_Java
Huffman coding algorithm in Java to achieve efficient compression and decompression of data while maintaining its integrity. Utilized various data structures such as HashMap, PriorityQueue, and Map to store and manipulate information effectively.

# Getting Started
These instructions will help you get a copy of the project up and running on your local machine for development and testing purposes.

# Prerequisites
To run the project, you need to have the following software installed on your machine:
->Java Development Kit (JDK) version 8 or higher
# How huffman algorithm works:
1. Character Frequency Calculation: The first step is to analyze the input data and determine the frequency of occurrence for each character. This frequency information is used to build the Huffman tree.

2. Building the Huffman Tree:
   -> Create a leaf node for each character along with its frequency.
   -> Put all the leaf nodes into a priority queue (min-heap) based on their frequencies. The node with the lowest frequency will have the highest priority.
   -> While there is more than one node in the priority queue:
      -Extract the two nodes with the lowest frequencies from the priority queue.
      -Create a new internal node with a frequency equal to the sum of the frequencies of the extracted nodes.
      -Set the extracted nodes as the left and right children of the new internal node.
      - Insert the new internal node back into the priority queue.
   -> The last remaining node in the priority queue becomes the root of the Huffman tree.

3. Assigning Huffman Codes:
  ->Traverse the Huffman tree from the root.
  ->Assign '0' to the left edge and '1' to the right edge of each node encountered during the traversal.
  ->Collect the binary codes from the root to each leaf node, forming the Huffman code for each character.
  ->Store these Huffman codes in a lookup table or a map for future use.

4. Data Compression:
  ->Replace each character in the input data with its corresponding Huffman code obtained from the lookup table.
  ->Concatenate these Huffman codes together to form the compressed data.

5. Data Decompression:
  ->Start from the root of the Huffman tree.
  ->For each bit in the compressed data, traverse the Huffman tree by following '0' for a left edge and '1' for a right edge.
  ->When reaching a leaf node, output the corresponding character and return to the root to continue decoding the next bit.
  ->Repeat this process until all bits in the compressed data have been processed.
   
The Huffman algorithm achieves compression by representing more frequently occurring characters with shorter codes and less frequently occurring characters with longer     codes. This results in a reduction in the overall size of the compressed data compared to the original input. The algorithm ensures that the codes are uniquely       decodable, as no code is a prefix of another code, allowing for accurate decompression and retrieval of the original data.
