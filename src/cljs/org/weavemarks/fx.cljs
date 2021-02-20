(ns org.weavemarks.fx
  (:require
   [re-frame.core :as re-frame]
   ["arweave" :default Arweave]))

(def arweave (.init Arweave))

(re-frame/reg-fx
 :jwk-to-address
 (fn [{:keys [key on-address]}]
   (-> arweave
       .-wallets
       (.jwkToAddress (js/JSON.parse key))
       (.then (fn [address]
                (on-address address))))))
