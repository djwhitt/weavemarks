(ns org.weavemarks.subs
  (:require
   [re-frame.core :as re-frame]))

(re-frame/reg-sub
 ::arweave-address
 (fn [db]
   (:arweave-address db)))
