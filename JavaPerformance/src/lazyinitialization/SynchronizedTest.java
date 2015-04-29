package lazyinitialization;

/*
 * In case a variable is very expensive to create then sometimes
 *  it is good to defer the creation of this variable until the variable
 *   is needed. This is called lazy initialization.

In general lazy initialization should only be used if a analysis has proven that
 this is really a very expensive operations.
  This is based on the fact that lazy initialization makes it more difficult to read the code.
 */

public class SynchronizedTest {
	  private MyField myField;

	  public synchronized MyField getMyField() {
	    if (myField == null) {
	      myField = new MyField();
	    }
	    return myField;
	  }

} 