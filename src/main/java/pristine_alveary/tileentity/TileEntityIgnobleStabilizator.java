package pristine_alveary.tileentity;

import forestry.api.apiculture.IBeeListener;
import forestry.api.multiblock.IAlvearyComponent;
import pristine_alveary.listener.IgnobleStabilizatorListener;

/**
 * PristineAlveary mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class TileEntityIgnobleStabilizator extends TileEntityBaseAlveary implements IAlvearyComponent.BeeListener {

    private final IBeeListener listener = new IgnobleStabilizatorListener(this);

    public TileEntityIgnobleStabilizator() {
        super();
    }

    @Override
    public IBeeListener getBeeListener() {
        return listener;
    }
}
