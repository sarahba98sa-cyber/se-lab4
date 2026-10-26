package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TorpedoStoreTest {

    private TorpedoStore store;

    @BeforeEach
    void setUp() {
        store = new TorpedoStore(5);
    }

    @Test
    void testIsEmptyFalse() {
        assertFalse(store.isEmpty());
    }

    @Test
    void testFireSuccess() {
        assertTrue(store.fire(1));
        assertEquals(4, store.getTorpedoCount());
    }

@Test
void testFireEmptyStore() {
    store = new TorpedoStore(1);
    assertTrue(store.fire(1));
    assertTrue(store.isEmpty());

    assertThrows(IllegalArgumentException.class, () -> store.fire(1));
    assertEquals(0, store.getTorpedoCount());
}

    @Test
    void testFireFailureAlways() {
        store = new TorpedoStore(5, 1.0);
        assertFalse(store.fire(1));
        assertEquals(5, store.getTorpedoCount());
    }
}
