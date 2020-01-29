import model.Box;
import model.Package;

import java.util.Arrays;

class Service {
    /**
     * Checks that packet fits within box. Any packet rotation allowed
     * @return true if packet fits within box
     */
    boolean isPackageFitInBox(Package packet, Box box) {
        double[] packetEdges = packet.edges();
        double[] boxEdges = box.edges();
        double[] boxDiags = box.diags();
        Arrays.sort(packetEdges);
        Arrays.sort(boxDiags);
        Arrays.sort(boxEdges);
        boolean result = true;
        for (int i = 0; i < packetEdges.length; i++) {
            result &= packetEdges[i] <= boxEdges[i];
        }
        if (!result) {
            double packetEdgesLength = 0;
            for (double edge : packetEdges) {
                packetEdgesLength += edge;
            }
            return packetEdgesLength <= boxDiags[boxDiags.length - 1];
        }
        return result;
    }
}
