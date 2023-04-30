package ua.lviv.iot.part1.lab5;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;

class WordsSorterTest {
    WordsSorter sorter = new WordsSorter();

    @Test
    public void testSortingString() {

        String a = "ad fdd rddrede j gdb ki bddh jedhf cdddd oiu";
        assertEquals("[j, ki, oiu, ad, gdb, jedhf, bddh, fdd, rddrede, cdddd]", sorter.sorterWords(a, 'd'));
    }

    @Test
    public void testSortingEmptyString() {
        assertEquals("[]", sorter.sorterWords("", 'b'));
    }

    @Test
    public void testSortingStringThatNotContainedNeededLetter() {
        String result = sorter.sorterWords("ad fdd rddrede j gdb ki bddh jedhf cdddd oiu", 'p');
        String expected = "[ad, bddh, cdddd, fdd, gdb, j, jedhf, ki, oiu, rddrede]";
        assertEquals(expected, result);
    }
}
