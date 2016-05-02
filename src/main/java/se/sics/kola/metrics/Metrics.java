/*
 * This file is part of the Kompics component model runtime.
 *
 * Copyright (C) 2009 Swedish Institute of Computer Science (SICS) 
 * Copyright (C) 2009 Royal Institute of Technology (KTH)
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package se.sics.kola.metrics;

import java.util.HashSet;
import org.joda.time.Duration;
import org.joda.time.format.PeriodFormat;

/**
 *
 * @author lkroll
 */
public class Metrics {

    private final HashSet<String> distinctOperators;
    private final HashSet<String> distinctOperands;
    private final int nuOperators;
    private final int nuOperands;
    private final long nOperators;
    private final long nOperands;
    private final long loc;
    private final int nFiles;

    Metrics(HashSet<String> distinctOperators, HashSet<String> distinctOperands,
            long nOperators, long nOperands, long loc, int nFiles) {
        this.distinctOperators = distinctOperators;
        this.distinctOperands = distinctOperands;
        this.nuOperators = distinctOperators.size();
        this.nuOperands = distinctOperands.size();
        this.nOperators = nOperators;
        this.nOperands = nOperands;
        this.loc = loc;
        this.nFiles = nFiles;
    }

    public int numDistinctOperators() {
        return this.nuOperators;
    }

    public int numDistinctOperands() {
        return this.nuOperands;
    }

    public long numOperators() {
        return this.nOperators;
    }

    public long numOperands() {
        return this.nOperands;
    }

    public long linesOfCode() {
        return this.loc;
    }
    
    public int numFiles() {
        return this.nFiles;
    }

    public long length() {
        return this.nOperators + this.nOperands;
    }

    public long vocabulary() {
        return this.nuOperators + this.nuOperands;
    }

    public double volume() {
        return length() * (Math.log(vocabulary()) / Math.log(2));
    }

    public double difficulty() {
        return ((double) this.nuOperators * this.nOperands) / ((double) 2 * this.nuOperands);
    }

    public double effort() {
        return difficulty() * volume();
    }

    public double expectedBugs() {
        return (effort() * 0.667) / 3000.0;
    }

    public Duration expectedTime() {
        double ts = effort() / 18;
        long tms = Math.round(ts * 1000.0);
        Duration d = new Duration(tms);
        return d;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Metrics (Halstead){\n   ");
        sb.append("Number of Source Files: F=");
        sb.append(this.numFiles());
        sb.append(",\n   ");
        sb.append("Lines of Code: loc=");
        sb.append(this.linesOfCode());
        sb.append(",\n   ");
        sb.append("Number of distinct/unique Operators: n1=");
        sb.append(this.numDistinctOperators());
        sb.append(",\n   ");
        sb.append("Number of distinct/unique Operands: n2=");
        sb.append(this.numDistinctOperands());
        sb.append(",\n   ");
        sb.append("Number of Operators: N1=");
        sb.append(this.numOperators());
        sb.append(",\n   ");
        sb.append("Number of Operands: N2=");
        sb.append(this.numOperands());
        sb.append(",\n   ");
        sb.append("Length: N=");
        sb.append(this.length());
        sb.append(",\n   ");
        sb.append("Vocabulary: n=");
        sb.append(this.vocabulary());
        sb.append(",\n   ");
        sb.append("Volume: V=");
        sb.append(this.volume());
        sb.append(",\n   ");
        sb.append("Difficulty: D=");
        sb.append(this.difficulty());
        sb.append(",\n   ");
        sb.append("Effort to implement or understand: E=");
        sb.append(this.effort());
        sb.append(",\n   ");
        sb.append("Number of expected Bugs: B=");
        sb.append(this.expectedBugs());
        sb.append(",\n   ");
        sb.append("Time that should be taken: T=");
        sb.append(this.expectedTime().getStandardSeconds());
        sb.append("s (");
        sb.append(PeriodFormat.getDefault().print(this.expectedTime().toPeriod()));
        sb.append(")");
        sb.append("\n}");
        return sb.toString();
    }

    public static Metrics merge(Metrics[] fileMetrics) {
        HashSet<String> distinctOperators = new HashSet<>();
        HashSet<String> distinctOperands = new HashSet<>();
        long nOperators = 0;
        long nOperands = 0;
        long loc = 0;
        int nFiles = 0;
        for (Metrics m : fileMetrics) {
            distinctOperators.addAll(m.distinctOperators);
            distinctOperands.addAll(m.distinctOperands);
            nOperators += m.nOperators;
            nOperands += m.nOperands;
            loc += m.loc;
            nFiles += m.nFiles;
        }
        return new Metrics(distinctOperators, distinctOperands, nOperators, nOperands, loc, nFiles);
    }

}
