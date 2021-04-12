import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class CasesTest {

    private Cases cases = Cases.getInstance();
    private ArrayList<Case> caselist = cases.getCaseList();
    
    private ArrayList<String> arrayList(String item1, String item2)
    {
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add(item1);
        arrayList.add(item2);
        return arrayList;
    }

    @BeforeEach
    public void setup()
    {
       Cases.getInstance().getCaseList().clear();
       DataWriter.saveCases();
       
    }

    @AfterEach
    public void tearDown()
    {
        Cases.getInstance().getCaseList().clear();
        DataWriter.saveCases();
       
    }

    @Test
    void testCreatingOneCase()
    {
        caselist.add(new Case(5, "Murder", "12/13/1990", "a man stabbed a woman in a robbery", "Hopeville, NC", arrayList("victims purse", "blood"), arrayList("Debra Keen", "Gerald Waye"),arrayList("Taako taco", "magnus burnside"), arrayList("Merle Highchurch", "Lup"), arrayList("Magic brian", "Lucia")));
        DataWriter.saveCases();
        assertEquals(5, DataLoader.getCases().get(0).getCaseNum());

    }

    @Test
    void testCreatingEmptyCase()
    {
        caselist.add(new Case(0, "", "", "", "", arrayList("", ""), arrayList("",""),arrayList("",""), arrayList("", ""), arrayList("", "")));
        DataWriter.saveCases();
        assertEquals(0, DataLoader.getCases().get(0).getCaseNum());
    }

    @Test
    void testCreatingThreeCases()
    {
        caselist.add(new Case(2, "Murder", "12/13/1990", "a man stabbed a woman in a robbery", "Hopeville, NC", arrayList("victims purse", "blood"), arrayList("Debra Keen", "Gerald Waye"),arrayList("Taako taco", "magnus burnside"), arrayList("Merle Highchurch", "Lup"), arrayList("Magic brian", "Lucia")));
        caselist.add(new Case(1, "Car chase", "12/13/1990", "a man stabbed a woman in a robbery", "Hopeville, NC", arrayList("victims purse", "blood"), arrayList("Debra Keen", "Gerald Waye"),arrayList("Taako taco", "magnus burnside"), arrayList("Merle Highchurch", "Lup"), arrayList("Magic brian", "Lucia")));
        caselist.add(new Case(3, "hit and run", "12/13/1990", "a man stabbed a woman in a robbery", "Hopeville, NC", arrayList("victims purse", "blood"), arrayList("Debra Keen", "Gerald Waye"),arrayList("Taako taco", "magnus burnside"), arrayList("Merle Highchurch", "Lup"), arrayList("Magic brian", "Lucia")));
        DataWriter.saveCases();
        assertEquals("hit and run", DataLoader.getCases().get(2).getCrimeType());

    }

    @Test
    void testZeroCases()
    {
        caselist = DataLoader.getCases();
        assertEquals(0, caselist.size());
    }

    @Test
    void testNullCases()
    {
        boolean hasNull = cases.haveCase(-1);
        assertFalse(hasNull);
    }
}
