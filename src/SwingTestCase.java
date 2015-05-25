import junit.framework.TestCase;

/**
 * Created by TheKarlBrown on 5/25/15.
 *
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

    public void testAreaCalculationOne(){
        testFrame.getRadiusTextField().setText("5");
        testFrame.getHeightTextField().setText("10");
        testFrame.convertButtonActionPerformed();
        assertEquals(785.398163397, Double.parseDouble(testFrame.getVolumeLabel().getText().substring(20,33)),.000000001);
    }
    public void testAreaCalculationZero(){
        testFrame.getRadiusTextField().setText("5");
        testFrame.getHeightTextField().setText("0");
        testFrame.convertButtonActionPerformed();
        assertEquals(0.0, Double.parseDouble(testFrame.getVolumeLabel().getText().substring(20, 22)),.000000001);
    }

}
