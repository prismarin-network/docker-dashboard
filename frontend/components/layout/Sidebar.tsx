import SidebarLink from "./SidebarLink";
import React, {FC} from "react";

import {IoLogoGithub} from "react-icons/io"
import {FiCommand, FiLayers, FiHardDrive} from "react-icons/fi"

declare interface SidebarProps {
    extended: boolean,
    pathName: string,
}

const Sidebar: FC<SidebarProps> = ({extended = false, pathName = ""}) => {

    return (
        <div
            className={`fixed flex flex-col lg:static z-20 h-screen w-72 bg-gray-100 dark:bg-bastille-500 transition-transform lg:transition-none ease-in-out duration-700 transform lg:transform-none ${!extended ? "-translate-x-80" : "translate-x-0"}`}>
            <div className="flex-grow mt-16">
                <ul className="flex flex-col space-y-1">
                    <SidebarLink
                        icon={<FiCommand />}
                        title="Dashboard"
                        pathName={pathName}
                        link="/"
                    />
                    <SidebarLink
                        icon={<FiLayers />}
                        title="Containers"
                        pathName={pathName}
                        link="/test"
                    />
                    <SidebarLink
                        icon={<FiHardDrive />}
                        title="Volumes"
                        pathName={pathName}
                        link="/test"
                    />
                </ul>
            </div>
            <div className="flex items-center justify-between font-outfit bg-blue-400 py-2 px-4 text-white">
                <span>
                    Version 0.1.0
                </span>
                <a
                    className="hover:text-gray-100"
                    href="https://github.com/prismarin-network/docker-dashboard"
                    target="_blank">
                    <IoLogoGithub size="1.4rem" />
                </a>
            </div>
        </div>
    )
}

export default Sidebar