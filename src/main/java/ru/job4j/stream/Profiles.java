package ru.job4j.stream;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Profiles {
    List<Address> collect(List<Profile> profiles) {
        return profiles.stream()
                .map(profile -> profile.getAddress())
                .collect(Collectors.toList());
    }

    List<Address> collectWithDistinctAndSort(List<Profile> profiles) {
    Comparator<Address> cityComparator = Comparator.comparing(Address::getCity);
    Comparator<Address> streetComparator = Comparator.comparing(Address::getStreet);
    Comparator<Address> homeComparator = Comparator.comparingInt(Address::getHome);
    Comparator<Address> apartmentComparator = Comparator.comparingInt(Address::getApartment);
    return profiles.stream()
            .map(profile -> profile.getAddress())
            .sorted(cityComparator
                    .thenComparing(streetComparator)
                    .thenComparing(homeComparator
                    .thenComparing(apartmentComparator)))
            .distinct()
            .collect(Collectors.toList());
    }
}
