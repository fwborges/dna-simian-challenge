# DNA Simian Challenge

Api Rest which is responsible to verify DNA Chain and returns if is simian or not.

# Instructions:

* ```mvn clean install```
* On target folder: ```java -jar simian-service-0.0.1-SNAPSHOT.jar```

* The database is MongoDB Atlas, feel free to change application properties with local mongo or docker, etc.

# Urls

* POST - https://mercado-livre-231923.appspot.com/simian

Example Matrix 15x15

```json
    {                         
      "dna": 
             ["ATCTGAGTGACTCGA",
              "CGGACAACTATCACA",
              "TATATGTGGCGGTCC",
              "GCTCTAATAGCGCGT",
              "AGGCCTCGTTAGATT",
              "GCAGGAATAGTCTAG",
              "TGTGCTCGTCAAGCG",
              "CTGAGACCACGTGCC",
              "AGAGGATGTGACACC",
              "CTCCAACACATCTGT",
              "GATGCCTGTGCGATT",
              "TCCATGCACAGTCGG",
              "TCTGCCGTGTGTCGG",
              "AGATATACATACGTA",
              "CTCAGCTGAGACGTA"]
    }
```


* GET - https://mercado-livre-231923.appspot.com/stats

