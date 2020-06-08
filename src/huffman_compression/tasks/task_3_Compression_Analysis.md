# Task  3: Compression Analysis

### Step 1. Compress the provided text files

Report Results:


| ﻿Time (ms) | Input File                          | Output File                   | Original Size (bits) | Compressed size (bits) | Compression Ratio |
|-----------|-------------------------------------|-------------------------------|----------------------|------------------------|-------------------|
| 6         | medTale.txt                         | medTaleCompressed.txt         | 45056                | 23912                  | 53.07%            |
| 5         | genomeVirus.txt                     | genomeVirusCompressed         | 50008                | 12576                  | 25.15%            |
| 103       | mobydick.txt                        | mobyDickCompressed            | 9531704              | 5341208                | 56.04%            |
| 1         | q32x48.bin                          | q32x48Compressed              | 1536                 | 816                    | 53.13%            |
| 39        | Pride_And_Prejudice-Jane_Austen.txt | pride_and_prejudiceCompressed | 1832216              | 1036904                | 56.59%            |

### Step 2. Decompress the files you compressed

| Time (ms) | Input File                    | Output File             | Bits    |
|-----------|-------------------------------|-------------------------|---------|
| 1         | q32x48Compressed              | q32x48Decompressed      | 1536    |
| 64        | mobyDickCompressed            | mobyDickDecompressed    | 9531704 |
| 6         | medTaleCompressed             | medTaleDecompressed     | 45056   |
| 3         | genomeVirusCompressed         | genomeVirusDecompressed | 50008   |
| 27        | pride_and_prejudiceCompressed | prejudiceDecompressed   | 1832216 |

### Step 3. Analysis of your results

We should observe that when decompressing we recover all the information from the original file so there is not loss of information. Also times to decompress are lower than times to compress files.

**Q3.** What happens if you try to compress one of the already compressed files?

We compressed the Pride and Prejudice file from an already compressed file and achieve a compressed radio of 98.9%.