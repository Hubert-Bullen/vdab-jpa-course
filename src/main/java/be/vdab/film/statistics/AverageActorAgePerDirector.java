package be.vdab.film.statistics;

public class AverageActorAgePerDirector {
    private String directorName;
    private double averageAge;

    public AverageActorAgePerDirector(String directorName, double averageAge) {
        this.directorName = directorName;
        this.averageAge = averageAge;
    }

    public String getDirectorName() {
        return directorName;
    }

    public double getAverageAge() {
        return averageAge;
    }

    @Override
    public String toString() {
        return String.format("Director '%s' has worked with actors with an average age of '%.2f' years", directorName, averageAge);
    }
}
