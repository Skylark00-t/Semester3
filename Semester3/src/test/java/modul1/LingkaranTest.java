package modul1;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LingkaranTest {

    @Test
    void hitungLuaslingkaranpositif() {
        double radius = 5.0;
        double expectedluas = 78.5;
        double actualluas = Lingkaran.hitungLuas(radius);
        assertEquals(expectedluas, actualluas, 0.01);
    }
    @Test
    void hitungLuasLingkarannegatif(){
        double radius = -2.0;
        assertThrows(IllegalArgumentException.class, () -> {Lingkaran.hitungLuas(radius);});
    }
    @Test
    void hitungluasLingkarannol(){
        double radius = 0.0;
        assertThrows(IllegalArgumentException.class, () -> {Lingkaran.hitungLuas(radius);});
    }

}