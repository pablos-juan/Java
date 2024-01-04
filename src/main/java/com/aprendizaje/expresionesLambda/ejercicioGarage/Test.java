package main.java.com.aprendizaje.expresionesLambda.ejercicioGarage;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        List<Vehiculo> vehiculos = new ArrayList<>();
        vehiculos.add(new Vehiculo("12B3", Marca.AUDI, 1200));
        vehiculos.add(new Vehiculo("34C5", Marca.MERCEDES, 1500));
        vehiculos.add(new Vehiculo("56D7", Marca.AUDI, 1800));
        vehiculos.add(new Vehiculo("78E9", Marca.TOYOTA, 3400));
        vehiculos.add(new Vehiculo("90F1", Marca.NISSAN, 1300));
        vehiculos.add(new Vehiculo("23G4", Marca.HONDA, 2050));
        vehiculos.add(new Vehiculo("45H6", Marca.BMW, 1600));
        vehiculos.add(new Vehiculo("67I8", Marca.MERCEDES, 1900));
        vehiculos.add(new Vehiculo("89J0", Marca.AUDI, 2200));
        vehiculos.add(new Vehiculo("01K2", Marca.HONDA, 1400));

        System.out.println("LISTA DE VEHÍCULOS MARCA-MATRÍCULA:");
        vehiculos.forEach(n -> System.out.println(
                "Marca: " + n.getMarca() + ", Matrícula: " + n.getMatricula()
        ));
        separador();

        System.out.println("CONVERSIÓN KILÓMETROS-MILLAS:");
        vehiculos.forEach(n -> System.out.println(
                "Matrícula: " + n.getMatricula() + ", millas: " + n.getKm()/1.60934
        ));
        separador();

        System.out.println("VEHÍCULOS MARCA AUDI:");
        vehiculos.stream()
                .filter(n -> n.getMarca().equals(Marca.AUDI))
                .forEach(System.out::println);
        separador();

        System.out.println("VEHÍCULOS ORDENADOS SEGÚN KILOMETRAJE:");
        vehiculos.stream()
                .sorted(Comparator.comparingInt(Vehiculo::getKm))
                .forEach(System.out::println);
        separador();

        System.out.println("MARCAS:");
        vehiculos.stream()
                .map(Vehiculo::getMarca)
                .distinct()
                .forEach(System.out::println);
        separador();

        System.out.println("VEHÍCULOS CON MÁS DE 2000 KM:");
        vehiculos.stream()
                .filter(m -> m.getKm()>2000)
                .forEach(System.out::println);
        separador();

        System.out.println("AGRUPACIÓN DE VEHÍCULOS POR MARCA:");
        Map<Marca, List<Vehiculo>> groupByMarca = vehiculos.stream()
                .collect(Collectors.groupingBy(Vehiculo::getMarca));
        groupByMarca.forEach((marca, lista) -> {
            System.out.println(marca + ":");
            lista.forEach(System.out::println);
        });
        separador();

        System.out.println("KILÓMETROS TOTALES:");
        int kmTotales = vehiculos.stream()
                .map(Vehiculo::getKm)
                .reduce(Integer::sum)
                .orElse(0);
        System.out.println(kmTotales + " km");
        separador();

        System.out.println("2 VEHÍCULO CON MENOS DE 2000 KM:");
        vehiculos.stream()
                .filter(m -> m.getKm()<2000)
                .limit(2)
                .forEach(System.out::println);
    }

    public static void separador() {
        System.out.println("----------------------------------------------");
    }
}