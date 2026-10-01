package range;

import java.util.Optional;

public class Range {
    private int start;
    private int end;
    private int step = 1;
    private boolean isStartIncluded = true;
    private boolean isEndIncluded = false;

    public Range(int start, int end, int step, boolean isStartIncluded, boolean isEndIncluded) {
        this.start = start;
        this.end = end;
        this.step = step;
        this.isStartIncluded = isStartIncluded;
        this.isEndIncluded = isEndIncluded;
    }

    public Range(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public boolean contains(int num) {
        var cleanlyInside = num > start && num < end;
        var equalsStartInOpen = num == start && isStartIncluded;
        var equalsEndInOpen = num == start && isEndIncluded; 

        return cleanlyInside || equalsStartInOpen || equalsEndInOpen;
    }

    public boolean contains (Range other) {
        // the start of other is contained in this and the end of other is contained in this
        return this.contains(other.start) && this.contains(other.end);
    }

    public Range union(Range other) throws RangeException {
        //if the start of other is not contained and the start of other is after the end of this, EXCEPTION!
        if (other.start > this.end || other.end < this.start) {
            throw new RangeException("Non-contiguous ranges can't be unioned!");
        }

        if (other.step != this.step) {
            throw new RangeException("These ranges have different steps");
        }

        var combinedStart = Math.min(this.start, other.start);
        var combinedEnd = Math.max(this.end, other.end);
        var isCombinedStartIncluded = combinedStart == this.start ? this.isStartIncluded : other.isStartIncluded;
        var isCombinedEndIncluded = combinedEnd == this.end ? this.isEndIncluded : other.isEndIncluded;

        return new Range(combinedStart, combinedEnd, this.step, isCombinedStartIncluded, isCombinedEndIncluded);
    }

    public Optional<Range> intersection(Range other) throws RangeException {
        if (other.start < this.start && !other.contains(this.end)) {
            return Optional.empty();
        }

        if (other.end > this.end && !this.contains(other.start)) {
            return Optional.empty();
        }

        if (other.step != this.step) {
            throw new RangeException("These ranges have different steps");
        }

        var combinedStart = Math.max(this.start, other.start);
        var combinedEnd = Math.min(this.end, other.end);
        var isCombinedStartIncluded = combinedStart == this.start ? this.isStartIncluded : other.isStartIncluded;
        var isCombinedEndIncluded = combinedEnd == this.end ? this.isEndIncluded : other.isEndIncluded;

        return Optional.of(new Range(combinedStart, combinedEnd, step, isCombinedStartIncluded, isCombinedEndIncluded));

    }

    public String toString() {
        return "(" + this.start + ", " + (this.start + step) + ",..., " + this.end + ")";
    }

    public static void main(String[] args) throws Exception{
        var range = new Range(1, 100, 1, true, false);
        var other = new Range(120, 150);
        System.out.println(range.contains(5));
        System.out.println(range.contains(1));
        System.out.println(range.contains(100));
        System.out.println(range);
        System.out.println(other);
        //System.out.println(range.union(other));
        var maybeIntersection = range.intersection(other);
        //var intersection = maybeIntersection.orElseThrow(() -> new Exception("Null range"));
        if (maybeIntersection.isEmpty()) {
            System.out.println("Empty intersection!");
        } else {
            System.out.println(maybeIntersection.get().start);
        }
    }
}
