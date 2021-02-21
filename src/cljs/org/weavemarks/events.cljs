(ns org.weavemarks.events
  (:require
   [re-frame.core :as re-frame]
   [org.weavemarks.db :as db]
   [org.weavemarks.fx]))

(re-frame/reg-event-db
 ::initialize-db
 (fn [_ _]
   db/default-db))

(re-frame/reg-event-db
 ::update-wallet-text
 (fn [db [_ s]]
   (assoc db :wallet-text s)))

(re-frame/reg-event-db
 ::set-address
 (fn [db [_ s]]
   (assoc db :arweave-address s)))

(re-frame/reg-event-fx
 ::init-wallet
 (fn [{:keys [db] :as _cofx} _]
   (let [{:keys [wallet-text]} db]
     {:db (assoc db
                 :wallet-text ""
                 :wallet-jwk wallet-text)
      :jwk-to-address {:key wallet-text
                       :on-success #(re-frame/dispatch [::set-address %])}})))

(re-frame/reg-event-fx
 ::add-bookmark
 (fn [{:keys [db] :as _cofx} _]
   {:transact {:key (:wallet-jwk db)
               :data {:title "David Whittington's Blog"
                      :url "https://www.djwhitt.com"}}}))
