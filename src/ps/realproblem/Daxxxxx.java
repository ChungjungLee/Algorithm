/*
    Tag Count 
    
    We have a stream of tags and we want to build a page to summarize the tags.
    Write a function that takes this list of tags returns the count of each tag.

    input = [
        'host:a,role:web,az:us-east-1a',
        'host:a,role:web,az:us-east-1b',
        'host:c,role:db,db_role:master,availability-zone:us-east-1e'
    ]

    output = {
        'db_role:master': 1,
        'az:us-east-1a': 1,
        'role:db': 1,
        'host:c': 1,
        'host:a': 2,
        'role:web': 2,
        'az:us-east-1e': 1,
        'az:us-east-1b': 1,
    }
 */
import java.io.*;
import java.util.*;

class Solution {
  public static void main(String[] args) {
    
    String[] input = {
        "host:a,role:web,az:us-east-1a",
        "host:a,role:web,az:us-east-1b",
        "host:c,role:db,db_role:master,availability-zone:us-east-1e"
    };

    Map<String, Integer> tagMap = new HashMap<String, Integer>();
    
    for (int i = 0; i < stream.length; i++) {
      String[] tags = stream[i].split(",");
      
      for (int j = 0; j < tags.length; j++) {
        if (!tagMap.containsKey(tags[j])) {
          tagMap.put(tags[j], 1);
        } else {
          tagMap.put(tags[j], tagMap.get(tags[j]) + 1);
        }
      }
    }
    
    for (Map.Entry<String, Integer> tag : tagMap.entrySet()) {
      System.out.println("'" + tag.getKey() + "': " + tag.getValue());
    }
  }
}