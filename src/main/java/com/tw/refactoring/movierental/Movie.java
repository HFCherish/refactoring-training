package com.tw.refactoring.movierental;

/**
 * @author pzzheng
 * @date 1/24/18
 */
public final class Movie {
    public static enum MovieCatetory {
        NORMAL {
            @Override
            public double charge(int daysRented) {
                return daysRented > 2 ? 1.5 * (daysRented - 2) : 2;
            }
        }, CHILDREN {
            @Override
            public double charge(int daysRented) {
                return daysRented > 3 ? 1.5 * (daysRented - 2) : 1.5;
            }
        }, NEW_RELEASE {
            @Override
            public double charge(int daysRented) {
                return daysRented * 3;
            }

            @Override
            public double points(int daysRented) {
                return daysRented > 1 ? 2 : 1;
            }
        };

        public abstract double charge(int daysRented);

        public double points(int daysRented) {
            return 1;
        }
    }

    private final MovieCatetory movieCatetory;
    private final String name;

    public Movie(String name, MovieCatetory movieCatetory) {
        this.movieCatetory = movieCatetory;
        this.name = name;
    }

    public MovieCatetory category() {
        return movieCatetory;
    }

    public String name() {
        return name;
    }
}
