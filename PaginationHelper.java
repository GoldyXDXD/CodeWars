/*
For this exercise you will be strengthening your page-fu mastery. You will complete the PaginationHelper class, which is a utility class helpful for querying paging information related to an array.

The class is designed to take in an array of values and an integer indicating how many items will be allowed per each page. The types of values contained within the collection/array are not relevant.
*/

import java.util.List;

// TODO: complete this object/class

public class PaginationHelper<I> {

  private List<I> collection;
  private int itemsPerPage;
  
  public PaginationHelper(List<I> collection, int itemsPerPage) {
    this.collection = collection;
    this.itemsPerPage = itemsPerPage;
  }
  
  /**
   * returns the number of items within the entire collection
   */
  public int itemCount() {
    return collection.size();
  }
  
  /**
   * returns the number of pages
   */
  public int pageCount() {
    if (collection.size() % itemsPerPage != 0) {
      return itemCount() / itemsPerPage + 1;
    }
    return itemCount() / itemsPerPage;
  }
  
  /**
   * returns the number of items on the current page. page_index is zero based.
   * this method should return -1 for pageIndex values that are out of range
   */
public int pageItemCount(int pageIndex) {
    if (pageIndex >= pageCount() || pageIndex < 0) 
      return -1;
    else if (pageIndex < pageCount()-1)
      return itemsPerPage;
    else
      return itemCount() % itemsPerPage;
  }
  
  /**
   * determines what page an item is on. Zero based indexes
   * this method should return -1 for itemIndex values that are out of range
   */
  public int pageIndex(int itemIndex) {
    if (itemIndex >= itemCount() || itemIndex < 0)
      return -1;
    else
      return itemIndex / itemsPerPage;  
  }
}
