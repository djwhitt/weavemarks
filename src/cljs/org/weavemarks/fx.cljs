(ns org.weavemarks.fx
  (:require
   [re-frame.core :as re-frame]
   ["arweave" :default Arweave]))

(def arweave (.init Arweave))

(re-frame/reg-fx
 :jwk-to-address
 (fn [{:keys [key on-success on-error]}]
   (-> (.-wallets arweave)
       (.jwkToAddress (js/JSON.parse key))
       (.then (fn [address]
                (when on-success
                  (on-success address))))
       (.catch (fn [error]
                 (when on-error
                   (on-error error)))))))
