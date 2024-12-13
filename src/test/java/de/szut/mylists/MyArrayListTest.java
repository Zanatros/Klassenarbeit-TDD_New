package de.szut.mylists;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MyArrayListTest {

    @Test
    public void givenAnEmptyListWhenSizeThenSizeIsZero(){
        MyArrayList list = new MyArrayList();
        assertThat(list.size()).isEqualTo(0);
    }

    @ParameterizedTest
    @CsvSource({"5", "7", "-1"})
    public void givenAnEmptyListWhenAddThenListContainsElement(int value){
        MyArrayList list = new MyArrayList();
        list.add(value);
        assertThat(list.size()).isEqualTo(1);
        assertThat(list.get(0)).isEqualTo(value);
    }

    @ParameterizedTest
    @CsvSource({"1, 2, 3", "5, 9, 22", "9, -5, 77"})
    public void givenAListWithThreeElementsWhenGetThenGetAllElements(int value1, int value2, int value3){
        MyArrayList list = new MyArrayList();
        list.add(value1);
        list.add(value2);
        list.add(value3);
        assertThat(list.size()).isEqualTo(3);
        assertThat(list.get(0)).isEqualTo(value1);
        assertThat(list.get(1)).isEqualTo(value2);
        assertThat(list.get(2)).isEqualTo(value3);
    }

    @ParameterizedTest
    @CsvSource({"1, 2, 3, 0", "5, 9, 22, 1", "9, -5, 77, 2"})
    public void givenAListWithThreeValuesWhenRemoveThenGetListWithRemovedIndex(int value1, int value2, int value3, int index){
        MyArrayList list = new MyArrayList();
        list.add(value1);
        list.add(value2);
        list.add(value3);
        list.remove(index);
        assertThat(list.size()).isEqualTo(2);
    }

    @ParameterizedTest
    @CsvSource({"1, 2, 3, 2, true", "5, 9, 22, 7, false", "9, -5, 77, 77, true"})
    public void givenAListWhenContainsThenReturnTrueOrFalseIfListContainsValue(int value1, int value2, int value3, int searchedValue, boolean expected){
        MyArrayList list = new MyArrayList();
        list.add(value1);
        list.add(value2);
        list.add(value3);
        assertThat(list.contains(searchedValue)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"1, 2, 3, 3", "5, 9, 22, -1", "9, -5, 77, 22"})
    public void givenAListWhenRemoveThenThrowExceptionIfIndexIsOutOfBounds(int value1, int value2, int value3, int index) throws RuntimeException{
        MyArrayList list = new MyArrayList();
        list.add(value1);
        list.add(value2);
        list.add(value3);
        assertThatThrownBy(() -> {
            list.remove(index);
        }).isInstanceOf(RuntimeException.class).hasMessageContaining("Dieser Index existiert nicht!");
    }

}
