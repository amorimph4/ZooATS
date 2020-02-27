import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import java.util.Map;


public class ZooTest {

    @Test
    public void test_class_instance_should_not_null(){
        Zoo mock = Mockito.spy(Zoo.class);
        Assert.assertNotNull(mock);
    }

    @Test
    public void test_add_unique_animal_with_zooCapacity(){
        Zoo zooSafari = new Zoo();
        zooSafari.setCapacity(1);
        zooSafari.addAnimal( "giraffle");
        Assert.assertTrue(zooSafari.getZoo().containsKey("giraffle"));
    }

    @Test
    public void test_add_unique_animal_without_zooCapacity(){
        Zoo zooSafari = new Zoo();
        zooSafari.setCapacity(0);
        zooSafari.addAnimal( "giraffle");
        Assert.assertFalse(zooSafari.getZoo().containsKey("giraffle"));
    }

    @Test
    public void test_add_duplicate_animal_with_zooCapacity(){
        Zoo zooSafari = new Zoo();
        zooSafari.setCapacity(2);
        zooSafari.addAnimal("giraffle");
        zooSafari.addAnimal("giraffle");
        Assert.assertEquals(2L,zooSafari.getZoo().get("giraffle").longValue());
    }

    @Test
    public void test_add_refused_animal(){
        Zoo zooSafari = new Zoo();
        zooSafari.addRefusedAnimal( "cat");
        Assert.assertTrue(zooSafari.getRefusedAnimals().contains("cat"));
    }

    @Test
    public void test_not_add_refused_animal_in_zoo(){
        Zoo zooSafari = new Zoo();
        zooSafari.addRefusedAnimal( "cat");
        zooSafari.addAnimal( "cat");
        Assert.assertFalse(zooSafari.getZoo().containsKey("cat"));
    }

    @Test
    public void test_remove_animal(){
        Zoo zooSafari = new Zoo();
        zooSafari.setCapacity(1);
        zooSafari.addAnimal("giraffle");
        zooSafari.removeAnimal("giraffle");
        Assert.assertFalse(zooSafari.getZoo().containsKey("cat"));
    }

    @Test
    public void test_has_capacity(){
        Zoo zooSafari = new Zoo();
        zooSafari.setCapacity(2);
        zooSafari.addAnimal("giraffle");
        Map<String,Integer> zooMap = zooSafari.getZoo();
        Assert.assertTrue(zooSafari.hasCapacity(zooMap));
    }

    @Test
    public void test_has_not_capacity(){
        Zoo zooSafari = new Zoo();
        zooSafari.setCapacity(1);
        zooSafari.addAnimal("giraffle");
        zooSafari.addAnimal("lion");
        Map<String,Integer> zooMap = zooSafari.getZoo();
        Assert.assertFalse(zooSafari.hasCapacity(zooMap));
    }

    @Test
    public void test_decrease_animal_there_is_no_exist_in_zoo(){
        Zoo zooSafari = new Zoo();
        zooSafari.decreaseAnimal("lion",1);
        Assert.assertTrue(zooSafari.getZoo().isEmpty());
    }

    @Test
    public void test_decrease_animal_there_is_less_quantity_in_zoo(){
        Zoo zooSafari = new Zoo();
        zooSafari.setCapacity(1);
        zooSafari.addAnimal("lion");
        zooSafari.decreaseAnimal("lion",2);
        Assert.assertTrue(zooSafari.getZoo().get("lion") == 1);
    }

    @Test
    public void test_decrease_animal_there_is_more_quantity_in_zoo(){
        Zoo zooSafari = new Zoo();
        zooSafari.setCapacity(2);
        zooSafari.addAnimal("tiger");
        zooSafari.addAnimal("tiger");
        zooSafari.decreaseAnimal("tiger",1);
        Assert.assertTrue(zoo.getZoo().get("tiger") == 1);
    }

}
