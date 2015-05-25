import junit.framework.TestCase;

/**
 * Created by TheKarlBrown on 5/25/15.
 * Test cases for the JUnit Section. Zero and Regular
 */
public class SwingTestCase extends TestCase {
    private TestableSwing testFrame;

    @Override
    protected void tearDown() throws Exception {
        if (this.testFrame != null){
            this.testFrame.dispose();
            this.testFrame=null;
        }
    }

    @Override
    protected void setUp() throws Exception {
        if (this.testFrame==null){
            this.testFrame=new TestableSwing();
        }
    }

    //Tests for a typical result
    public void testAreaCalculationOne(){
        testFrame.getRadiusTextField().setText("5");
        testFrame.getHeightTextField().setText("10");
        testFrame.convertButtonActionPerformed();
        assertEquals(785.398163397, Double.parseDouble(testFrame.getVolumeLabel().getText().substring(20,33)),.000000001);
    }

    //Checks that Zero is handled properly
    public void testAreaCalculationZero(){
        testFrame.getRadiusTextField().setText("5");
        testFrame.getHeightTextField().setText("0");
        testFrame.convertButtonActionPerformed();
        assertEquals(0.0, Double.parseDouble(testFrame.getVolumeLabel().getText().substring(20, 22)),.000000001);
    }

}
