# DNA Simian Challenge

Api Rest which is responsible to verify DNA Chain and returns if is simian or not. This Api was built based on clean architecture principles.

# Instructions:

* ```mvn clean install```
* On target folder: ```java -jar simian-service-0.0.1-SNAPSHOT.jar```

* The database is MongoDB Atlas, feel free to change application properties with local mongo or docker, etc.

# Urls (Google App Engine)

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


# Coverage

Line coverage is 84%. To build report, run: ``` mvn jacoco:report ``` and 
go to ```dna-simian-challenge/target/site/jacoco/index.html``` file to open report.

# References

* https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html
* https://www.infoq.com/br/presentations/transformando-sua-arquitetura-com-clean-architecture


