# Wikipedia Enrich

The goal of this Spark script, is to combine Wikipedia page data with DBpedia information such that all sentences of a Wikipedia page are annotated with BIO-tags for corresponding DBpedia records. As an example, consider a snippet of the Wikipedia page of Barack Obama:

```Barack Hussein Obama II (born August 4, 1961) is an American politician...```

Suppose that DBpedia has the following information:

```[BARACK OBAMA] has_job [POLITICIAN]```
```[BARACK OBAMA] is_born_on [AUGUST 4, 1961]```

Then, the sentence could be annotated as follows:

```Barack Hussein Obama II (born August[is_born_on] 4,[is_born_on] 1961[is_born_on]) is an American politician[has_job]...```

However, this is not an easy task. Several assumptions and simplifications are used which are explained in the next section.

## Assumptions and Simplifications

- Only pages referring to a single entity are used.
- Only pages in English are used.
- Only DBpedia information is used which is about the entity the page is about.
- Each word in a page can refer to multiple labels.

## Algorithm

The algorithm executes the following steps:

1. Each node is assigned a page.
2. Corresponding DBpedia information is fetched about the entity the page is about. This information and the page contents are then stored in an additional XML file.
3. In the second pass, the enriched XML files are used and each node is assigned an XML file.
4. For each XML file, a possible mapping between properties and words are made.

## Notes
First note that this process does not result into perfectly matched properties and words. The resulting dataset is used for training a model which could possibly extract features from a text.