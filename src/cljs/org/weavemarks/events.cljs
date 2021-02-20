(ns org.weavemarks.events
  (:require
   [re-frame.core :as re-frame]
   [org.weavemarks.db :as db]
   [day8.re-frame.tracing :refer-macros [fn-traced]]
   ["arweave" :default Arweave]))

(def arweave (.init Arweave))

(re-frame/reg-event-db
 ::initialize-db
 (fn-traced [_ _]
   db/default-db))
