(ns clj-screeps.core)

(enable-console-print!)

(defn- inspect
  ; Log to the console the passed-in value, and return the value.  This
  ; basically allows one to insert this debug printer anywhere by simply
  ; wrapping forms with its call.

  ([value]
   (js/console.log value)
   value)
  ([value message]
   (js/console.log message value)
   value))

(defn ^:export on-tick
  ; Screeps calls this script periodically.  Our goal for this version is to
  ; spawn a creep.  We convert this JavaScript:
  ;
  ;     Game.spawns['Spawn1'].createCreep( [WORK, CARRY, MOVE], 'Harvester1' );
  ;
  ; to a ClojureScript equivalent.  A dirt-simple approach would just be:
  ;
  ;     (js/Game.spawns.Spawn1.createCreep #js [js/WORK js/CARRY js/MOVE] "Harvester1")
  ;
  ; But what if, instead of "Spawn1", our spawn was called "My Spawn"?  You
  ; would need to use the noisier `aget` approach, which is demonstrated here.

  []
  (-> js/Game
      (aget "spawns" "Spawn1")
      (.createCreep #js [js/WORK js/CARRY js/MOVE] "Harvester1")))

