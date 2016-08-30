package pristine_alveary;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import pristine_alveary.block.*;
import pristine_alveary.gui.GuiHandler;
import pristine_alveary.proxy.CommonProxy;
import pristine_alveary.tileentity.TileEntityLifeReducer;
import pristine_alveary.tileentity.TileEntityMutator;
import pristine_alveary.tileentity.TileEntityPristinizator;

/**
 * PristineAlveary mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
@Mod(modid = ModInfo.ID, name = ModInfo.NAME, version = ModInfo.VERSION, dependencies = "required-after:Forestry@[4.2.,);")
public class PristineAlvearyMod {
    @Mod.Instance("PristineAlveary")
    public static PristineAlvearyMod instance;
    @SidedProxy(clientSide = "pristine_alveary.proxy.ClientProxy", serverSide = "pristine_alveary.proxy.CommonProxy")
    public static CommonProxy proxy;

    public static BlockIgnobleStabilizator blockIgnobleStabilizator;
    public static BlockGeneticDecaySuppressor blockGeneticDecaySuppressor;
    public static BlockPristinizator blockPristinizator;
    public static BlockLifeReducer blockLifeReducer;
    public static BlockMutator blockMutator;

    public PristineAlvearyMod() {
        instance = this;
    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
//        GraveStoneConfig.getInstance(event.getModConfigurationDirectory().getAbsolutePath() + "/PristineAlveary/", "PristineAlveary.cfg");
    }

    @Mod.EventHandler
    public void load(FMLInitializationEvent event) {

//        blockIgnobleStabilizator = new BlockIgnobleStabilizator();
//        GameRegistry.registerBlock(blockIgnobleStabilizator, "blockIgnobleStabilizator");
//        LanguageRegistry.addName(blockIgnobleStabilizator, "IgnobleStabilizator");

        blockGeneticDecaySuppressor = new BlockGeneticDecaySuppressor();
        GameRegistry.registerBlock(blockGeneticDecaySuppressor, "blockGeneticDecaySuppressor");
        LanguageRegistry.addName(blockGeneticDecaySuppressor, "GeneticDecaySuppressor");

        blockPristinizator = new BlockPristinizator();
        GameRegistry.registerBlock(blockPristinizator, "blockPristinizator");
        LanguageRegistry.addName(blockPristinizator, "Pristinizator");

        blockLifeReducer = new BlockLifeReducer();
        GameRegistry.registerBlock(blockLifeReducer, "blockLifeReducer");
        LanguageRegistry.addName(blockLifeReducer, "LifeReducer");

        blockMutator = new BlockMutator();
        GameRegistry.registerBlock(blockMutator, "blockMutator");
        LanguageRegistry.addName(blockMutator, "Mutator");


//        GameRegistry.registerTileEntity(TileEntityIgnobleStabilizator.class, "TileEntityIgnobleStabilizator");
//        GameRegistry.registerTileEntity(TileEntityGeneticDecaySuppressor.class, "TileEntityGeneticDecaySuppressor");
        GameRegistry.registerTileEntity(TileEntityPristinizator.class, "TileEntityPristinizator");
        GameRegistry.registerTileEntity(TileEntityLifeReducer.class, "TileEntityLifeReducer");

        GameRegistry.registerTileEntity(TileEntityMutator.class, "TileEntityMutator");

        Recipes.initialize();

        NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
    }
}
