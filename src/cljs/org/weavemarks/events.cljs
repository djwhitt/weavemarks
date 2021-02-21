(ns org.weavemarks.events
  (:require
   [re-frame.core :as re-frame]
   [org.weavemarks.db :as db]
   [org.weavemarks.fx]
   [day8.re-frame.tracing :refer-macros [fn-traced]]))

(re-frame/reg-event-db
 ::initialize-db
 (fn-traced [_ _]
   db/default-db))

(re-frame/reg-event-db
 ::update-wallet
 (fn-traced [db [_ s]]
   (assoc db :wallet-input s)))

(re-frame/reg-event-db
 ::set-address
 (fn-traced [db [_ s]]
   (assoc db :arweave-address s)))

(re-frame/reg-event-fx
 ::init-wallet
 (fn-traced [{:keys [db] :as _cofx} _]
   {:db (assoc db
               :wallet-input ""
               :wallet-jwk (:wallet-input db))
    :jwk-to-address {:key (:wallet-input db)
                     :on-success #(re-frame/dispatch [::set-address %])}}))
