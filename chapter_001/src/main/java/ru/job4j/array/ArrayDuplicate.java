package ru.job4j.array;

import java.util.Arrays;

/**
 * Array duplicate.
 *
 * @author Maksym Mateiuk (maxymmateuk@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class ArrayDuplicate {
   public String[] remove(String[] array) {
      int end = array.length;
      for (int i = 0; i < end; i++) {
         for (int j = i + 1; j < end; j++) {
            if (array[i].equals(array[j])) {
               if (!array[i].equals(array[end - 1])) {
                  array[i] = array[end - 1];
               }
               end--;
               j--;
            }
         }
      }
      return Arrays.copyOf(array, end);
   }
}
