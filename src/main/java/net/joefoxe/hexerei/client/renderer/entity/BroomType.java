package net.joefoxe.hexerei.client.renderer.entity;

import net.minecraft.world.item.Item;

import java.util.HashSet;
import java.util.Set;

//@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public record BroomType(String name, Item item, float speedMultiplier) {
    private static final Set<BroomType> VALUES = new HashSet<>();

    public static BroomType create(String name, Item item, float speedMultiplier) {
        BroomType broomType = new BroomType(name, item, speedMultiplier);
        VALUES.add(broomType);
        return broomType;
    }

    public static Set<BroomType> getValues() {
        return VALUES;
    }

    public static BroomType byName(String name) {
        for (BroomType type : VALUES) {
            if (type.name.equalsIgnoreCase(name)) {
                return type;
            }
        }
        return VALUES.stream().toList().get(0);
    }

    public static BroomType byId(int id) {
        if (id >= 0 && id < VALUES.size())
            return VALUES.stream().toList().get(id);
        return VALUES.stream().toList().get(0);
    }

//    @SubscribeEvent
//    public static void registerModels(final FMLClientSetupEvent event) {
//        for (BroomType broomType : VALUES) {
//            event.enqueueWork(() -> {
//                Hexerei.LOGGER.info("Registering model for " + broomType.name);
//                ModelProvider.registerModel(broomType.getModel(), (resourceLocation) -> {
//                    try (InputStreamReader reader = new InputStreamReader(event.getModLoader().getModClassLoader().getResourceAsStream(resourceLocation.getPath()))) {
//                        JsonObject modelJson = new JsonParser().parse(reader).getAsJsonObject();
//                        return new BroomModel(modelJson);
//                    } catch (Exception e) {
//                        throw new RuntimeException("Error loading broom model " + resourceLocation, e);
//                    }
//                });
//            });
//        }
//    }

//    public static void loadBroomTypes() {
//        Gson gson = new Gson();
//        try (InputStreamReader reader = new InputStreamReader(BroomType.class.getResourceAsStream("/data/hexerei/broom_types.json"))) {
//            Set<BroomType> types = gson.fromJson(reader, new TypeToken<Set<BroomType>>() {}.getType());
//            VALUES.addAll(types);
//            Hexerei.LOGGER.info("Loaded " + VALUES.size() + " broom types.");
//        } catch (Exception e) {
//            throw new RuntimeException("Error loading broom types", e);
//        }
//
//        System.out.println(VALUES.size());
//    }

//    public static List<BroomType> loadBroomTypes() {
//        Gson gson = new Gson();
//        List<BroomType> broomTypes = new ArrayList<>();
//
//        try (InputStreamReader inputStreamReader = new InputStreamReader(BroomType.class.getResourceAsStream("/data/hexerei/broom_types.json"))){
//            BufferedReader reader = new BufferedReader(inputStreamReader);
//            JsonObject jsonObject = gson.fromJson(reader, JsonObject.class);
//
//            if (jsonObject.has("broom_types")) {
//                // If the JSON object contains a "broom_types" property, use that array
//                JsonArray jsonArray = jsonObject.getAsJsonArray("broom_types");
//                for (JsonElement jsonElement : jsonArray) {
//                    BroomType broomType = gson.fromJson(jsonElement, BroomType.class);
//                    broomTypes.add(broomType);
//                }
//            } else if (jsonObject.isJsonArray()) {
//                // If the JSON object is an array, use that array
//                JsonArray jsonArray = jsonObject.getAsJsonArray();
//                for (JsonElement jsonElement : jsonArray) {
//                    BroomType broomType = gson.fromJson(jsonElement, BroomType.class);
//                    broomTypes.add(broomType);
//                }
//            } else {
//                throw new RuntimeException("Invalid broom types JSON: must contain an array of broom types or an object with a 'broom_types' property containing the array");
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        VALUES.addAll(broomTypes);
//
//        return broomTypes;
//    }
}
