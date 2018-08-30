package beans;

import repositories.BusStopInLineRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BusLine {
    private String id;
    private String name;
    private List<BusStopInLine> stopsInLine;

    public BusLine(String id, String name) {
        this.id = id;
        this.name = name;
        this.stopsInLine = new ArrayList<BusStopInLine>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BusStopInLine> getStopsInLine() {
        return stopsInLine;
    }

    public void setStopsInLine(List<BusStopInLine> stopsInLine) {
        this.stopsInLine = stopsInLine;
    }

    public void addStopToLine(BusStop stop, String itineraryName, String direction, int directionID, int ttrOrder, int rttOrder) throws NullPointerException {
        if (stop != null) {
            BusStopInLine newRelation = new BusStopInLine(stop, this, itineraryName, direction, directionID, ttrOrder, rttOrder);
            this.stopsInLine.add(newRelation);
            BusStopInLineRepository bsl = BusStopInLineRepository.getInstance();
            bsl.addBusStopInLine(newRelation);
        } else {
            throw new NullPointerException();
        }
    }

    public void printStopsInLine() {
        //this.stopsInLine.sort(Comparator.comparing(BusStopInLine::getRttOrder));
        System.out.print(this + "\n");
        for(int i = 0; i < this.stopsInLine.size(); i++) {
            System.out.print(this.stopsInLine.get(i) + "\n");
        }
    }

    @Override
    public String toString() {
        return "BusLine{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}