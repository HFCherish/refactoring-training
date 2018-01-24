package com.tw.refactoring.movierental;

/**
 * @author pzzheng
 * @date 1/24/18
 */
public final class Rental {
    private final Movie movie;
    private final int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public double points() {
        return movie.category().points(daysRented);
    }

    public Movie movie() {
        return movie;
    }

    public int daysRented() {
        return daysRented;
    }

    public double getCharge() {
        return movie.category().charge(daysRented);
    }

}
