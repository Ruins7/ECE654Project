/**
 * 
 * 在方法出现异常时优先重置对象
 * 
 * @author ruins7
 *
 */

class TestERR03 {
  private int length;
  private int width;
  private int height;
  static public final int PADDING = 2;
  static public final int MAX_DIMENSION = 10;

  public TestERR03(int length, int width, int height) {
    this.length = length;
    this.width = width;
    this.height = height;
  }

  protected int getVolumePackage(int weight) {
    length += PADDING;
    width  += PADDING;
    height += PADDING;
    try {
      if (length <= PADDING || width <= PADDING || height <= PADDING ||
        length > MAX_DIMENSION + PADDING || width > MAX_DIMENSION + PADDING ||
        height > MAX_DIMENSION + PADDING || weight <= 0 || weight > 20) {
        throw new IllegalArgumentException();
      }
      System.out.println(length+" "+width+" "+height);
      int volume = length * width * height; // 12 * 12 * 12 = 1728
      length -= PADDING; width -= PADDING; height -= PADDING; // Revert
      System.out.println(length+" "+width+" "+height);
      return volume;
    } catch (Throwable t) {
    	   //MyExceptionReporter mer = new MyExceptionReporter();
       //mer.report(t); // Sanitize
      return -1;
    } // Non-positive error code
   }
   

  

  public static void main(String[] args) {
	  TestERR03 d = new TestERR03(10, 10, 10);
	  System.out.println(d.getVolumePackage(21)); // Prints -1 (error)
	  System.out.println(d.getVolumePackage(19)); // Prints 2744(14^3) instead of 1728(12^3)
  }
}