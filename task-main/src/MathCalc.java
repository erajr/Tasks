
public class MathCalc {
    public static void main(String[] args) {

        // Problem 1: Language basics
        
        // Question: The diameter of the Sun is approximately 865,000 miles. The
        // diameter of the Earth is approximately 7600 miles.
        // Use the methods in the class Math to calculate,
        // a) the volume of the Earth in cubic miles
        // b) the volume of the Sun in cubic miles
        // c) the ratio of the volume of the Sun to the volume of the Earth
        // Treat both the earth and sun as spheres. The volume of a sphere is given by
        // the formula 4 pi r^3/3 where r is the radius

        // To calculate radius of Earth and Sun, we use formula r = d/2
        // Earth diameter = 7600 miles
        // Sun diameter = 865000 miles

        double earthRadius = 7600 / 2;
        double sunRadius = 865000 / 2;

        double earthVolume = (4 * Math.PI * Math.pow(earthRadius, 3)) / 3;
        double sunVolume = (4 * Math.PI * Math.pow(sunRadius, 3)) / 3;

        System.out.println("The volume of the Earth is " + earthVolume + " cubic miles, " +
                "the volume of the sun is " + sunVolume + " cubic miles, " +
                "and the ratio of the volume of the Sun to the volume of the Earth is " + sunVolume / earthVolume
                + ":1");

    }
}
