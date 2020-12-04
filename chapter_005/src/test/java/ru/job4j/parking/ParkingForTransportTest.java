package ru.job4j.parking;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ParkingForTransportTest {

    /**
     * Когда каждый вид транспорта занимает свое место на парковке
     */
    @Test
    public void whenTransportItsPlace() {
        Transport car = new Car("Car", "1a", 1);
        Transport truck = new Truck("Truck", "2b", 3);
        Parking parking = new ParkingForTransport(5, 5);
        parking.add(car);
        parking.add(truck);
        assertThat(parking.getParkingCar().containsValue(car), is(true));
        assertThat(parking.getParkingTruck().containsValue(truck), is(true));
    }

    /**
     * Когда транспорт заезжает и потом выезжает
     */
    @Test
    public void whenTransportExit() {
        Transport car = new Car("Car", "1a", 1);
        Transport truck = new Truck("Truck", "2b", 3);
        Parking parking = new ParkingForTransport(5, 5);
        parking.add(car);
        parking.add(truck);
        assertThat(parking.delete(car), is(car));
        assertThat(parking.delete(truck), is(truck));
    }

    /**
     * Когда места для грузовых машин заполняются и
     * грузовые машины паркуются на парковке для легковых машин
     */
    @Test
    public void whenTransportTakesPlaceCar() {
        Transport car = new Car("Car", "1a", 1);
        Transport truckOne = new Truck("Truck", "2b", 3);
        Transport truckTwo = new Truck("Truck", "3c", 2);
        Transport truckThree = new Truck("Truck", "4d", 3);
        Parking parking = new ParkingForTransport(10, 2);
        parking.add(car);
        parking.add(truckOne);
        parking.add(truckTwo);
        parking.add(truckThree);
        assertThat(parking.getParkingCar().containsValue(truckThree), is(true));
        assertThat(parking.getParkingCar().size(), is(4));
    }

    /**
     * Когда обе парковки заполнены
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void whenParkingFull() {
        Transport One = new Car("Car", "1a", 1);
        Transport truckOne = new Truck("Truck", "2b", 3);
        Transport truckTwo = new Truck("Truck", "3c", 2);
        Transport truckThree = new Truck("Truck", "4d", 3);
        Transport carTwo = new Car("Car", "5f", 1);
        Parking parking = new ParkingForTransport(4, 2);
        parking.add(One);
        parking.add(truckOne);
        parking.add(truckTwo);
        parking.add(truckThree);
        parking.add(carTwo);
    }
}
