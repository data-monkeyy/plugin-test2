package com.example;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.*;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

import org.json.JSONArray;
import org.json.JSONObject;

import net.runelite.api.events.GameTick;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.Tile;

import java.util.ArrayList;
import java.util.List;

import java.net.InetSocketAddress;


@Slf4j
@PluginDescriptor(
	name = "Example"
)
public class ExamplePlugin extends Plugin
{
	@Inject
	private Client client;

	private GameTickWebSocketServer server;

	@Inject
	private ExampleConfig config;

	@Override
	protected void startUp() throws Exception {
		InetSocketAddress address = new InetSocketAddress("localhost", 8080);
		server = new GameTickWebSocketServer(address);
		server.start();
	}

	@Override
	protected void shutDown() throws Exception {
		if (server != null) {
			server.stop();
		}
	}

//	@Subscribe
//	public void onGameStateChanged(GameStateChanged gameStateChanged)
//	{
//		if (gameStateChanged.getGameState() == GameState.LOGGED_IN)
//		{
//			client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", "sus", null);
//			client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", "amongus", null);
//		}
//	}

	@Subscribe
	public void onGameTick(GameTick event)
	{
		// chin tiles
		WorldPoint point_1 = new WorldPoint(2517, 9296, 0);
		WorldPoint point_2 = new WorldPoint(2516, 9296, 0);
		WorldPoint point_3 = new WorldPoint(2515, 9296, 0);
		WorldPoint point_4 = new WorldPoint(2514, 9296, 0);
		WorldPoint point_5 = new WorldPoint(2513, 9296, 0);

		LocalPoint localPoint_1 = LocalPoint.fromWorld(client, point_1);
		LocalPoint localPoint_2 = LocalPoint.fromWorld(client, point_2);
		LocalPoint localPoint_3 = LocalPoint.fromWorld(client, point_3);
		LocalPoint localPoint_4 = LocalPoint.fromWorld(client, point_4);
		LocalPoint localPoint_5 = LocalPoint.fromWorld(client, point_5);

		JSONObject trap1Json = new JSONObject();
		JSONObject trap2Json = new JSONObject();
		JSONObject trap3Json = new JSONObject();
		JSONObject trap4Json = new JSONObject();
		JSONObject trap5Json = new JSONObject();

		try {

			Tile tile_1 = client.getScene().getTiles()[point_1.getPlane()][localPoint_1.getSceneX()][localPoint_1.getSceneY()];
			Tile tile_2 = client.getScene().getTiles()[point_2.getPlane()][localPoint_2.getSceneX()][localPoint_2.getSceneY()];
			Tile tile_3 = client.getScene().getTiles()[point_3.getPlane()][localPoint_3.getSceneX()][localPoint_3.getSceneY()];
			Tile tile_4 = client.getScene().getTiles()[point_4.getPlane()][localPoint_4.getSceneX()][localPoint_4.getSceneY()];
			Tile tile_5 = client.getScene().getTiles()[point_5.getPlane()][localPoint_5.getSceneX()][localPoint_5.getSceneY()];

			trap1Json = jsonDTO(tile_1);
			trap2Json = jsonDTO(tile_2);
			trap3Json = jsonDTO(tile_3);
			trap4Json = jsonDTO(tile_4);
			trap5Json = jsonDTO(tile_5);

		} catch(Exception e) {}

		JSONObject trapInfo = new JSONObject();

		trapInfo.put("trap1", trap1Json);
		trapInfo.put("trap2", trap2Json);
		trapInfo.put("trap3", trap3Json);
		trapInfo.put("trap4", trap4Json);
		trapInfo.put("trap5", trap5Json);

		// amethyst tiles
		WorldPoint amethyst_1_wp = new WorldPoint(3007, 9705, 0);
		WorldPoint amethyst_2_wp = new WorldPoint(3006, 9705, 0);
		WorldPoint amethyst_3_wp = new WorldPoint(3005, 9705, 0);
		WorldPoint amethyst_4_wp = new WorldPoint(3006, 9709, 0);
		WorldPoint amethyst_5_wp = new WorldPoint(3007, 9709, 0);

		LocalPoint amethyst_1_lp = LocalPoint.fromWorld(client, amethyst_1_wp);
		LocalPoint amethyst_2_lp = LocalPoint.fromWorld(client, amethyst_2_wp);
		LocalPoint amethyst_3_lp = LocalPoint.fromWorld(client, amethyst_3_wp);
		LocalPoint amethyst_4_lp = LocalPoint.fromWorld(client, amethyst_4_wp);
		LocalPoint amethyst_5_lp = LocalPoint.fromWorld(client, amethyst_5_wp);

		int wallObject_id_1 = 0;
		int wallObject_id_2 = 0;
		int wallObject_id_3 = 0;
		int wallObject_id_4 = 0;
		int wallObject_id_5 = 0;

		try {

			Tile amethyst_1_tile = client.getScene().getTiles()[amethyst_1_wp.getPlane()][amethyst_1_lp.getSceneX()][amethyst_1_lp.getSceneY()];
			Tile amethyst_2_tile = client.getScene().getTiles()[amethyst_2_wp.getPlane()][amethyst_2_lp.getSceneX()][amethyst_2_lp.getSceneY()];
			Tile amethyst_3_tile = client.getScene().getTiles()[amethyst_3_wp.getPlane()][amethyst_3_lp.getSceneX()][amethyst_3_lp.getSceneY()];
			Tile amethyst_4_tile = client.getScene().getTiles()[amethyst_4_wp.getPlane()][amethyst_4_lp.getSceneX()][amethyst_4_lp.getSceneY()];
			Tile amethyst_5_tile = client.getScene().getTiles()[amethyst_5_wp.getPlane()][amethyst_5_lp.getSceneX()][amethyst_5_lp.getSceneY()];

			WallObject wallObject1 = amethyst_1_tile.getWallObject();
			WallObject wallObject2 = amethyst_2_tile.getWallObject();
			WallObject wallObject3 = amethyst_3_tile.getWallObject();
			WallObject wallObject4 = amethyst_4_tile.getWallObject();
			WallObject wallObject5 = amethyst_5_tile.getWallObject();

			wallObject_id_1 = wallObject1.getId();
			wallObject_id_2 = wallObject2.getId();
			wallObject_id_3 = wallObject3.getId();
			wallObject_id_4 = wallObject4.getId();
			wallObject_id_5 = wallObject5.getId();

		} catch (Exception e){
		}
		JSONObject amethystInfo = new JSONObject();

		amethystInfo.put("amethyst_1", wallObject_id_1);
		amethystInfo.put("amethyst_2", wallObject_id_2);
		amethystInfo.put("amethyst_3", wallObject_id_3);
		amethystInfo.put("amethyst_4", wallObject_id_4);
		amethystInfo.put("amethyst_5", wallObject_id_5);


		// runstone tiles
		JSONObject northStoneMineableJson = new JSONObject();
		JSONObject southStoneMineableJson = new JSONObject();

		Boolean northStoneMineable = null;
		Boolean southStoneMineable = null;
		try {
			northStoneMineable = client.getVarbitValue(4927) == 0;
			southStoneMineable = client.getVarbitValue(4928) == 0;

		} catch (Exception e){}

		JSONObject runestoneInfo = new JSONObject();

		runestoneInfo.put("isNorthStoneMineable", northStoneMineable);
		runestoneInfo.put("isSouthStoneMineable", southStoneMineable);

		// unique invent item ids
		JSONArray InventoryItemIDs = new JSONArray();
		// for (Item item : client.getItemContainer(InventoryID.INVENTORY).getItems())
		for (Item item : client.getItemContainer(InventoryID.INVENTORY).getItems())
		{
			InventoryItemIDs.put(item.getId());
		}

		JSONObject finalJson = new JSONObject();
		finalJson.put("trap_info", trapInfo);
		finalJson.put("amethyst_info", amethystInfo);
		finalJson.put("special_attack_info", client.getVarpValue(VarPlayer.SPECIAL_ATTACK_PERCENT));
		finalJson.put("inventory_item_count", client.getItemContainer(InventoryID.INVENTORY).count());
		finalJson.put("runestone_info", runestoneInfo);
		finalJson.put("inventory_item_IDs", InventoryItemIDs);

		if (server != null) {
			server.broadcast(finalJson.toString());
		}
	}

	public JSONObject jsonDTO(Tile tile) {
		JSONArray groundItemIDsJson = new JSONArray();
		JSONArray gameObjectIDsJson = new JSONArray();

		if (tile.getGameObjects() != null)
		{
			for (GameObject gameObject : tile.getGameObjects()) {
				if (gameObject != null) {
					gameObjectIDsJson.put(gameObject.getId());
				}
			}
		}

		if (tile.getGroundItems() != null)
		{
			for (TileItem groundItem : tile.getGroundItems()) {
				if (groundItem != null) {
					groundItemIDsJson.put(groundItem.getId());
				}
			}
		}


		JSONObject jsonObj = new JSONObject();
		jsonObj.put("gameObjectIDs", gameObjectIDsJson);
		jsonObj.put("groundItemIDs", groundItemIDsJson);

		return jsonObj;
	}


	@Provides
	ExampleConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(ExampleConfig.class);
	}
}
