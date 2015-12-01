package pristine_alveary.tileentity;

import forestry.api.apiculture.IAlvearyComponent;
import forestry.api.apiculture.IBeeListener;
import net.minecraft.inventory.IInventory;
import pristine_alveary.listener.IgnobleStabilizatorListener;

/**
 * PristineAlveary mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class TileEntityIgnobleStabilizator extends TileEntityBaseAlveary {

    private final IBeeListener listener = new IgnobleStabilizatorListener(this);

    public TileEntityIgnobleStabilizator() {
        super();
    }

    @Override
    public void initialize() {
        if (getCentralTE() != null) {
            ((IAlvearyComponent) getCentralTE()).registerBeeListener(listener);
        }
    }

    @Override
    protected void updateServerSide() {
        super.updateServerSide();
        if (!updateOnInterval(200)) {
            return;
        }

        if (!hasMaster() || !isIntegratedIntoStructure()) {
            return;
        }

        ((IAlvearyComponent) getCentralTE()).registerBeeListener(listener);
    }
}
