package day04;

import day02.Movie;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CourierFileManager {

    private List<Ride> listScanned = new ArrayList<>();

    public List<Ride> getListScanned() {
        return listScanned;
    }

    public void createCourierByFile(Path path){
        try {
            List<String> lines = Files.readAllLines(path);
            fillList(lines);
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file.", ioe);
        }
    }

    private void fillList(List<String> lines) {
        for (String s: lines){
            String[] tmp = s.split(" ");
            listScanned.add(new Ride(Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1]), Integer.parseInt(tmp[2])));
        }
    }
}
